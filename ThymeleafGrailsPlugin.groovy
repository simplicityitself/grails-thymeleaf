import org.springframework.beans.factory.config.BeanReferenceFactoryBean
import org.thymeleaf.spring3.SpringTemplateEngine
import org.thymeleaf.spring3.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.FileTemplateResolver
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

  def issueManagement = [system: "Github", url: "http://www.github.com/simplicityitself/grails-thymeleaf/issues"]

  def scm = [url: "http://www.github.com/simplicityitself/grails-thymeleaf"]


  def doWithSpring = {

    if (application.warDeployed) {
      thymeLeafTemplateResolver(ServletContextTemplateResolver) { bean ->
        prefix = '/WEB-INF/grails-app/views'
        suffix = ".html"
        templateMode = "HTML5"
        cacheable = true
      }
    } else {
      thymeLeafTemplateResolver(FileTemplateResolver) { bean ->
        prefix = 'grails-app/views'
        suffix = ".html"
        templateMode = "HTML5"
        cacheable = false
      }
    }
    thymeLeafTemplateEngine(SpringTemplateEngine) {
      templateResolver = ref("thymeLeafTemplateResolver")
    }
    viewResolver(ThymeleafViewResolver) {
      templateEngine = ref("thymeLeafTemplateEngine")
      order = 10
      viewNames = ["*"] as String[]
      //TODO, verify what this should be
      cache = false
    }
    //This overrides the view resolver used to resolve bound URL views.
    //Effectively disables both GSP and JSP :-)
    springConfig.addAlias 'jspViewResolver', 'viewResolver'
  }
}
