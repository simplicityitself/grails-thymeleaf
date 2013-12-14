import org.codehaus.groovy.grails.commons.ApplicationAttributes
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.context.ApplicationContext
import org.springframework.web.servlet.ViewResolver

class BootStrap {

    def init = { servletContext ->
      ApplicationContext ctx = servletContext.getAttribute(ApplicationAttributes.APPLICATION_CONTEXT)

      println "BEANS=${ctx.getBeansOfType(ViewResolver)}"
    }
    def destroy = {
    }
}
