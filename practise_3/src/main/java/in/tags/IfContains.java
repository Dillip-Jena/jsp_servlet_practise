package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class IfContains extends SimpleTagSupport {
    private String text;
    private String word;

    public void setText(String text) { this.text = text; }
    public void setWord(String word){ this.word = word; }

    @Override
    public void doTag() throws JspException, IOException{
        if(!text.isEmpty() && !word.isEmpty() && text.contains(word)){
            if(getJspBody() != null){
                getJspBody().invoke(null);
            }
        }
    }
}
