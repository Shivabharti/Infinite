package com.java.hms.controller;

import no.tornado.web.html.Div;
import no.tornado.web.html.Form;
import no.tornado.web.engine.Controller;
import no.tornado.web.annotations.Page;
import com.java.hms.template.MainTemplate;
import com.java.hms.content.HelloWorld;

@Page(path = "/")
public class Index extends Controller<MainTemplate> {
    Form form;
    Div feedback;

    public void execute() throws Exception {
        form = form(
                fieldset(getString("loginLegend"),
                        textinput("username").pattern("[A-Za-z0-9_-]{1,15}").title(getString("usernameHint")).autofocus(),
                        password("password").required(),
                        submit("login", () -> {
                            String msg = String.format(getString("loggedIn"), form.value("username"), form.value("password"));
                            feedback.replaceInner(div("alert alert-success", msg));
                        })
                )
        );

        feedback = div("#feedback");

        template.content.add(form, feedback, HelloWorld.class);

        template.navbar.add(
                li(a(Index.class, text(getString("index"))))
        );
    }
}
