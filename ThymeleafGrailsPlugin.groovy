import org.thymeleaf.spring3.SpringTemplateEngine
import org.thymeleaf.spring3.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ServletContextTemplateResolver

class ThymeleafGrailsPlugin {

  def version = "0.1"
  def grailsVersion = "2 > *"
  def pluginExcludes = [
          "grails-app/views/error.gsp"
  ]

  def title = "Grails Thymeleaf Plugin" // Headline display name of the plugin
  def author = "David Dawson"
  def authorEmail = "david.dawson@simplicityitself.com"
  def description = '''\
Integrate Thymeleaf as the View rendering technology
'''

  def documentation = "http://grails.org/plugin/thymeleaf"

  def license = "APACHE"

  def organization = [name: "Simplicity Itself", url: "http://www.simplicityitself.com/"]

  def issueManagement = [ system: "Github", url: "http://www.github.com/simplicityitself/grails-thymeleaf/issues" ]

  def scm = [ url: "http://www.github.com/simplicityitself/grails-thymeleaf" ]

  def doWithWebDescriptor = { xml ->
    // TODO Implement additions to web.xml (optional), this event occurs before
  }

  def doWithSpring = {
    // TODO Implement runtime spring config (optional)

    templateResolver(ServletContextTemplateResolver) { bean ->
      prefix = ''
      suffix = ".html"
      templateMode = "HTML5"
      //TODO, verify what this should be
      cacheable=false
    }
    templateEngine(SpringTemplateEngine) {
      templateResolver=ref("templateResolver")
    }
    viewResolver(ThymeleafViewResolver) {
      templateEngine=ref("templateEngine")
      order=10
      viewNames=["*"] as String[]
      //TODO, verify what this should be
      cache=false
    }

  }

  def doWithDynamicMethods = { ctx ->
    // TODO Implement registering dynamic methods to classes (optional)
  }

  def doWithApplicationContext = { ctx ->
    // TODO Implement post initialization spring config (optional)
  }

  def onChange = { event ->
    // TODO Implement code that is executed when any artefact that this plugin is
    // watching is modified and reloaded. The event contains: event.source,
    // event.application, event.manager, event.ctx, and event.plugin.
  }

  def onConfigChange = { event ->
    // TODO Implement code that is executed when the project configuration changes.
    // The event is the same as for 'onChange'.
  }

  def onShutdown = { event ->
    // TODO Implement code that is executed when the application shuts down (optional)
  }
}
