resource "aws_vpc" "appspring_vpc_1" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support   = true


  tags = {
    "Name" = "appspring_vpc_1"
  }

}

resource "aws_subnet" "appspring_subnet" {
    vpc_id     = aws_vpc.appspring_vpc_1.id
    cidr_block = "10.0.1.0/24"
    availability_zone = "us-east-1a"
    map_public_ip_on_launch = true

    tags = {
      Name = "springapp-subnet_pub"

  }
}


resource "aws_internet_gateway" "springapp_igw" {
    vpc_id = aws_vpc.appspring_vpc_1.id


    tags = {
      "Name" = "springapp_igw"
    }
}

resource "aws_route_table" "springapp_rtb" {
  vpc_id         = aws_vpc.appspring_vpc_1.id

  tags = {
    "Name" = "springapp_rtb"
  }

}

resource "aws_route" "springapp_route" {
  route_table_id = aws_route_table.springapp_rtb.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id = aws_internet_gateway.springapp_igw.id


}


resource "aws_route_table_association" "spring_rtb_ass" {
  route_table_id = aws_route_table.springapp_rtb.id
  subnet_id = aws_subnet.appspring_subnet.id
}

resource "aws_instance" "springapp_ec2" {

  instance_type = "t2.micro"
  key_name = aws_key_pair.springapp_key.id
  vpc_security_group_ids = [aws_security_group.springapp_sg.id]
  subnet_id = aws_subnet.appspring_subnet.id

  ami = data.aws_ami.springapp_ami.id

  user_data = file("userdata.tpl")


  root_block_device {
    volume_size = 8
  }

  tags = {
    "Name" = "springapp_ec2"
  }


}



