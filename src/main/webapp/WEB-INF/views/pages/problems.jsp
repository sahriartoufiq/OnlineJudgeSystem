<%--
  Created by IntelliJ IDEA.
  User: sahriar
  Date: 1/2/17
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>

<form role="form" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="problm">Problem: </label>
        <input type="file" class="form-control" id="problm" name="problm"/>
    </div>
    <div class="form-group">
        <label for="input">Input:</label>
        <input type="file" class="form-control" id="input" name="input"/>
    </div>
    <div class="form-group">
        <label for="output">Output:</label>
        <input type="file" class="form-control" id="output" name="output"/>
    </div>
    <div class="form-group">
        <label for="timeLimit">Time Limit:</label>
        <input type="text" class="form-control" id="timeLimit" name="timeLimit"/>
    </div>

    <div class="form-group">
        <label for="memoryLimit">MemoryLimit:</label>
        <input type="text" class="form-control" id="memoryLimit"  name="memoryLimit"/>
    </div>
    <div class="form-group">
        <label for="category">Category:</label>
        <input type="text" class="form-control" id="category" name="category">
    </div>

    <input type="submit" class="btn btn-default" value="Upload" />
</form>