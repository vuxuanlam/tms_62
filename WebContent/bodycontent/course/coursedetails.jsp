<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <h2 class="text-center">Course Details</h2>
    <div class="row">
        <h3>Course name: ${currentCourse.name }</h3>
        <strong>Description:</strong> <br>
        <p>${currentCourse.description }</p>
        <strong>Dtart date: </strong> ${currentCourse.startDate }<br> <strong>End
            date:</strong>${currentCourse.endDate }<br> <strong>Status:</strong>
        <s:if test="currentCourse.status">
            <span class="text-danger">Active</span>
        </s:if>
        <s:else>
        Closed
        </s:else>

    </div>
</div>
