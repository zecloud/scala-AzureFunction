# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.162.0/containers/ubuntu/.devcontainer/base.Dockerfile

# [Choice] Ubuntu version: bionic, focal
ARG VARIANT="focal"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-${VARIANT}
RUN wget -q https://packages.microsoft.com/config/ubuntu/20.04/packages-microsoft-prod.deb
RUN dpkg -i packages-microsoft-prod.deb
RUN apt-get update
RUN sudo apt-get install azure-functions-core-tools-3
RUN apt-get install -y --no-install-recommends software-properties-common
RUN add-apt-repository -y ppa:openjdk-r/ppa
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt-get install -y openjdk-8-jre
RUN update-alternatives --config java
RUN update-alternatives --config javac
RUN \
  curl -L -o sbt-1.4.9.deb http://dl.bintray.com/sbt/debian/sbt-1.4.9.deb && \
  dpkg -i sbt-1.4.9.deb && \
  rm sbt-1.4.9.deb && \
  apt-get update && \
  apt-get install sbt 
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
RUN curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash
# RUN apt-get install ca-certificates curl apt-transport-https lsb-release gnupg
# RUN curl -sL https://packages.microsoft.com/keys/microsoft.asc |  gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/microsoft.gpg > /dev/null 
# RUN AZ_REPO=$(lsb_release -cs) ## outputs the codename for the linux distribution i.e. Ubuntu 18.04 = bionic
#  echo "deb [arch=amd64] https://packages.microsoft.com/repos/azure-cli/ $AZ_REPO main" | ## outputs the entire url with the codename appended.
#      sudo tee /etc/apt/sources.list.d/azure-cli.list ## writes that URL to the package resource list
# RUN sudo apt-get update && sudo apt-get install azure-cli
#RUN export SDKMAN_DIR="/usr/local/sdkman" && curl -s "https://get.sdkman.io" | bash && /bin/bash -c 'source "/usr/local/sdkman/bin/sdkman-init.sh" && sdk install java $(sdk list java | grep -o "8\.[0-9]*\.[0-9]*\.hs-adpt" | head -1)  && sdk install sbt'
# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>


