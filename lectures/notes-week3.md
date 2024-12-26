# Introduction to Cloud Computing

### What is It?
- delivering computing resources (servers, storage, databaswes, netowrking, software, etc.) over the internet
- accessing resources on demand from cloud provider

### Relation to DevOps
- **Scalability and Flexibility:** rapid scaling up or down of resources based on applications demands
- **Automation:** continuous integration, delivery, and deployment (CI/CD pipelines)
- **Cost Efficiency:** Pay-as-you go pricing models aligns with incremental / iterative nature of devops
- **Global Reach:** Enables team across geographies sto collaborate in real-time, essential for DevOps practices

### Types
- **IaaS (Infrastructure as a Service):** virtual hardware and network infrastructure - low-elvel software for you to build the enviornment and your application in
    - VMs (virtual machines) like AWS EC2
- **PaaS (Platform as a Service):** Offers toools and frameworks for application development and eployment
    - Docker, AWS RDS
- **SaaS (Software as a Service):** Supplies software applications that can streamline DevOps workflows

### Models
    - **public**: ran by third party cloud providers to deliver services to their clients over the internet
    - **private**: only one indivdual / business use the resources / storage of private cloud
    - **hybrid**: combines both public / private clouds

# DevOps Overview

### DevOps = Development and Operations
- dev -> design app ; operations -> deploy and maintain system
- DevOps combines developmenting and Operations
- expedite lifecycle of application development and deployment through automation

### General Steps
1. **Source Code Control:** produce or write code and push to repo with other members' code
2. **Building and Testing:** running unit test and ensuring code base can be compiled into a functional artifact
3. **Staging Deployment:** deploy the build to an environment where higher-level testing can be done, integration, and end-toend testing generally
4. **Acceptance Testing:** More complex/higher-level testing to ensure the build meets quality standards and will be appreciate by end users
5. **Production Deployment:** Migrating working build from staging to production where end users can see new code base. **Monitoring** deployment to ensure that it continues to function

## CI/CD
### Continuous Integration (CI)
- Process of regularly merging code into a central repository that will be integrated with previously existing codebase. Sometimes basic unit testing and building of the code
- Automation Tools
    - Git

### Continuous Delivery (CD)
- Automate DevOps process through a pipeline
- After code integration / unit testing, artifact built into staging environment where it is tested
- Automation Tools
    - Jenkins
    - CircleCI

### Continuous Deployment (CD)
- taking artifact from staging and deploy it where end users can access in production environment
- Automation Tools
    - Jenkins


# AWS - Amazon Web Services
### Amazon's Cloud Offering
- hundreds of services AWS provides that can provide building blocks for most IT infrastructures
    - pay for what you use
    - each service is utilized different 
    - but generally highly scalable and thus can control your costs paying for only what you need
        - purchase additioinal resources increasing performance of existing or resources
        - or duplicating resources to run in tandem (horziontal scaling)

### Region Locations
- Regions: geogrpahic areas of world that are served by two orm ore AZ (available zone)
- Available Zones (AZ): phyiscal locations of hardware
- goal is that every connection to AZ in a region should be fast enough
 between AZs in that zone.

### Some AWS Service
- RDS - Relational Database Service: virtual, scalable, relational database
- EC2 - Elastic Compute Cloud: Virtual computer/server (VM)
- AMI - Amazon Machine Image: blueprint for os so you can mount AMI on an EC2 to determine what base vm will have
- Security Groups: functions like firewall for isntances and restrict access by port/protocol, etc.
- S3 - Simple Storage Solution: static storage, usually for webpages or image storage
- Route53 - Domain Name System: assign resources their web addresses.
- ELB - Elastic Load Balancing: load balcner and gateway service. can direct request across horizontally scaled resources
- EC2 Autoscaling: automatically add and remove EC2 instances according to conditions you define
    - Benefits: lowers cost, increase application availability, improve fault tolerance

