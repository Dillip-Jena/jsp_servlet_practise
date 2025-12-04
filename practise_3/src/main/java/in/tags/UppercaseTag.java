package in.tags;

import java.io.IOException;
import java.io.StringWriter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class UppercaseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException{
        StringWriter sw = new StringWriter();

        if(getJspBody() != null){
            getJspBody().invoke(sw); 
        }

        String output = sw.toString().toUpperCase();
        getJspContext().getOut().write(output);
    }
}
