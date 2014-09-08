Magma [![Build Status](https://travis-ci.org/ObsidianBox/Magma.png?branch=master)](https://travis-ci.org/ObsidianBox/Magma) [![Coverage Status](https://coveralls.io/repos/ObsidianBox/Magma/badge.png)](https://coveralls.io/r/ObsidianBox/Magma)
=============
Magma is an API that extends Minecraft Forge to easier deliver content through addons. It is licensed under the [MIT License]

* [Homepage]
* [Source]
* [Issues]
* [Chat]: #obsidiandev on irc.esper.net

## Prerequisites
* [Java] 7
* [Gradle] 1.12+

## Cloning
If you are using Git, use this command to clone the project: `git clone git@github.com:ObsidianBox/Magma.git`

## Setup
__Note:__ If you do not have [Gradle] installed then use ./gradlew for Unix systems or Git Bash and gradlew.bat for Windows systems in place of any 'gradle' command.

__For [Eclipse]__  
  1. Run `gradle setupDecompWorkspace --refresh-dependencies`  
  2. Make sure you have the Gradle plugin installed (Help > Eclipse Marketplace > Gradle Integration Plugin)  
  3. Import Magma as a Gradle project (File > Import)
  4. Select the root folder for Magma and click **Build Model**
  5. Check Magma when it finishes building and click **Finish**

__For [IntelliJ]__  
  1. Run `gradle setupDecompWorkspace --refresh-dependencies`  
  2. Make sure you have the Gradle plugin enabled (File > Settings > Plugins).  
  3. Click File > Import Module and select the **build.gradle** file for Magma.

## Building
__Note:__ If you do not have [Gradle] installed then use ./gradlew for Unix systems or Git Bash and gradlew.bat for Windows systems in place of any 'gradle' command.

In order to build Magma you simply need to run the `gradle` command.

## Contributing
Are you a talented programmer looking to contribute some code? We'd love the help!
* Open a pull request with your changes, following our [guidelines and coding standards](http://wiki.obsidianbox.org/Contributing).
* Please follow the above guidelines and requirements for your pull request(s) to be accepted.

Love the project? Feel free to [donate] to help continue development! Magma is open-source and powered by community members, like yourself. Without you, we wouldn't be here today!

## FAQ
__A dependency was added, but my IDE is missing it! How do I add it?__
>If a new dependency was added, you can just restart your IDE and the Gradle plugin for that IDE should pull in the new dependencies.

__Help! Things are not working!__
>Some issues can be resolved by deleting the '.gradle' folder in your user directory and running through the setup steps again, or even running `gradle cleanCache` and running through the setup again. Otherwise if you are having trouble with something that the README does not cover, feel free to join our IRC channel and ask for assistance.

[Chat]: http://obsidianbox.org/chat/
[Donate]: http://obsidianbox.org/donate/
[Eclipse]: http://www.eclipse.org/
[Gradle]: http://www.gradle.org/
[Homepage]: http://obsidianbox.org/
[IntelliJ]: http://www.jetbrains.com/idea/
[Issues]: http://obsidianbox.org/community/support/
[Java]: http://java.oracle.com/
[Source]: https://github.com/ObsidianBox/Magma/
[MIT License]: http://www.tldrlegal.com/license/mit-license
