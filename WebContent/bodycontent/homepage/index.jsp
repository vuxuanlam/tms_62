<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <s:if test="hasActionErrors()">
        <div class="alert alert-danger" role="alert">
            <s:actionerror />
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div class="alert alert-info" role="alert">
            <s:actionmessage />
        </div>
    </s:if>
    <sec:authorize access="!isAuthenticated()">
        <div class="jumbotron text-center">
            <h1>Hello :D</h1>
            <p>I am Training Management System</p>
            <p>Can I help you</p>
            <p>
                <a class="btn btn-primary btn-lg" href='<s:url value="/sign/signin"></s:url>'
                    role="button">Sign in</a>
            </p>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h3>
            <a href="courseadmin/viewallcourse">Courses Manager</a>
        </h3>
        <h3>
            <a href="subjectadmin/viewallsubject">Subject Manager</a>
        </h3>
        <h3>
            <a href="accountadmin/viewallaccount">Account Manager</a>
        </h3>
    </sec:authorize>
</div>
