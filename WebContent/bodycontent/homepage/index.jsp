<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <s:if test="hasActionErrors()">
        <div class="alert alert-danger" role="alert">
            <s:actionerror />
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div class="alert alert-success" role="alert">
            <s:actionmessage />
        </div>
    </s:if>
    <s:if test="!#session.current_user">
        <div class="jumbotron text-center">
            <h1>Hello :D</h1>
            <p>I am Training Management System</p>
            <p>Can I help you</p>
            <p>
                <a class="btn btn-primary btn-lg" href='<s:url value="/sign/signinpage"></s:url>'
                    role="button">Sign in</a>
            </p>
        </div>
    </s:if>
</div>
