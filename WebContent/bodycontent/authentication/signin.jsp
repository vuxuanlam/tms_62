<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Form signin -->
<div class="container">
    <div class="row">
        <h3 class="text-center">Signin</h3>
        <div class="col-md-8 col-md-offset-2">
            <s:if test="hasActionErrors()">
                <div class="alert alert-danger" role="alert">
                    <s:actionerror />
                </div>
            </s:if>
            <s:form class="form-horizontal" method="POST"
                action="/j_spring_security_check">
                <div class="form-group">
                    <label for="email" class="col-md-3 control-label">Email*</label>
                    <div class="col-md-9">
                        <input type="email" class="form-control" id="email"
                            name="email" placeholder="Email" required="required"
                            autocomplete="on" autofocus="autofocus">
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">Password*</label>
                    <div class="col-md-9">
                        <input type="password" class="form-control"
                            id="password" name="password" placeholder="Password"
                            required="required" pattern=".{6,16}"> <input
                            type="checkbox" value="yes"
                            name="_spring_security_remember_me" /> Remember me
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary btn-block">Sign
                            in</button>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>
