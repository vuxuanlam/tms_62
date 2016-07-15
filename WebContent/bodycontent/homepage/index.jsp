<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test="!#session.current_user">
    <div class="container">
        <div class="jumbotron text-center">
            <h1>Hello :D</h1>
            <p>I am Training Management System</p>
            <p>Can I help you</p>
            <p>
                <a class="btn btn-primary btn-lg" href='<s:url value="/sign/signinpage"></s:url>'
                    role="button">Sign in</a>
            </p>
        </div>
    </div>
</s:if>