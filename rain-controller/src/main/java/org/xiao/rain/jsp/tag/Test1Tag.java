package org.xiao.rain.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/12/3 23:45
 */
public class Test1Tag implements Tag {
    
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    private PageContext pageContext = null;
    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {

    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public int doStartTag() throws JspException {

        String method = ((HttpServletRequest)pageContext.getRequest()).getMethod();

        JspWriter writer = pageContext.getOut();

        try {
            writer.write(method);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
