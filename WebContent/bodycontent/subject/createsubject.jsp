<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <div class="row">
        <h3 class="text-center">Create Subject</h3>
        <div class="col-md-8 col-md-offset-2">
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
            <s:form class="form-horizontal" method="POST"
                action="/subjectadmin/createsubject">
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">Name*</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" id="name"
                            name="subject.name" placeholder="Name of subject"
                            required="required">
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <label for="description" class="col-md-3 control-label">Description*</label>
                    <div class="col-md-9">
                        <textarea class="form-control" rows="3" id="description"
                            placeholder="Description of subject"
                            name="subject.description" required="required"></textarea>
                    </div>
                </div>
                <br>
                <br>
                <div id="task"></div>
                <div class="list-task-item">
                    <div class="task-item">
                        <div class="form-group">
                            <label for="task-name"
                                class="col-md-3 control-label">Task Name</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control"
                                    id="task-name" name="taskName"
                                    placeholder="Task name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="task-description"
                                class="col-md-3 control-label">Task
                                Description</label>
                            <div class="col-md-9">
                                <textarea class="form-control" rows="3"
                                    id="task-description"
                                    placeholder="Description of Task"
                                    name="taskDescription"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-md-9">
                        <br> <a type="button"
                            class="btn btn-default btn-block" id="add-task">Add
                            task</a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-md-9">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block">Create</button>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>
