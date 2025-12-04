package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class SumTag extends SimpleTagSupport {
    private int a;
    private int b;

    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }

    @Override
    public void doTag() throws IOException{
        int sum = a + b;
        getJspContext().getOut().write(String.valueOf(sum));
    }
}
