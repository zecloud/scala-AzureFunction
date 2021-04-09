# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.162.0/containers/ubuntu/.devcontainer/base.Dockerfile

# [Choice] Ubuntu version: bionic, focal
ARG VARIANT="focal"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-${VARIANT}
RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN curl -s "https://get.sdkman.io" | bash 
RUN /bin/bash -c 'source "/root/.sdkman/bin/sdkman-init.sh" && sdk install java $(sdk list java | grep -o "8\.[0-9]*\.[0-9]*\.hs-adpt" | head -1)  && sdk install sbt'
RUN wget -q https://packages.microsoft.com/config/ubuntu/20.04/packages-microsoft-prod.deb
RUN dpkg -i packages-microsoft-prod.deb
RUN apt-get update
RUN sudo apt-get install azure-functions-core-tools-3
# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>


