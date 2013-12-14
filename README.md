# Thymeleaf Plugin

Adds support for using [Thymeleaf[(http://www.thymeleaf.org/) views in Grails.

Currently removes support for both GSP and JSP when installed, so be careful.  Once installed, only Thymeleaf views will be available.

## Limitations

Very early release, not suitable for production.

Especially not tested :-

* That model variables are available.
* That the normal grails exposed beans are available (they aren't)
* That the render command will use this (it probably won't)
* That taglibs will work (they won't)

Contribs and comments welcome in the github issues.


## Installation

Add the latest version of the plugin to the BuildConfig.groovy

```groovy

  plugins {
    runtime ':thymeleaf:0.1'
  }

```

## Roadmap

* Expose the grails model properly along with the normal beans.
* Test/ add support for plugin hosted views.
* Test/ add support for the render command.
* Investigate taglibs and whether they could integrate.
* Ensure performance is good enough.
