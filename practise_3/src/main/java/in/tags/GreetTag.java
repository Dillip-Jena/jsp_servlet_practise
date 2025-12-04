package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class GreetTag extends SimpleTagSupport {
    private String name;

    public void setName(String name){ this.name = name; }

    @Override
    public void doTag() throws IOException{
        JspWriter out = getJspContext().getOut();
        out.write("Hello, " + name + " this is custom JSP tag.");
    }
}
