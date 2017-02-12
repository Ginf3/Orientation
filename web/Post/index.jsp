<%--
  Created by IntelliJ IDEA.
  Post: ismailrei
  Date: 1/24/17
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Posts</title>
</head>
<body>
<div data-ng-app="appPost">
    <div data-ng-controller="PostController">
        <tbody>
        <tr>
            <td><input class="form-control" type="hidden" ng-model="post.id"/></td>
            <td><input class="form-control" ng-model="post.title"/></td>
            <td><input class="form-control" ng-model="post.content"/></td>
            <td><input class="form-control" ng-model="post.picture"/></td>
            <td><input class="form-control" ng-model="post.filiere"/></td>
            <td>
                <button data-ng-click="addorUpdatePost()">Add Post</button>
            </td>
            <td>
                <button data-ng-click="addorUpdatePost()">update</button>
            </td>
            <td>
                &nbsp;&nbsp;
                <button class="btn btn-info" ng-click="deselect()">Clear</button>
            </td>
        </tr>
        </tr>
        </tbody>

        <button data-ng-click="getDataFromServer()">
            get Posts
        </button>
        <div ng-repeat="Post in Posts">
            <td>id : {{post.id}}</td>
            <td> title : {{post.title}}</td>
            <td> content : {{post.content}}</td>
            <td> picture : {{post.picture}}</td>
            <td> filiere : {{post.filiere}}</td>
            <td>
                <button class="btn btn-warning" ng-click="get(post.id)">Edit</button>
            </td>
            <td>
                <button class="btn btn-warning" ng-click="deletePost(post.id)">Delete</button>
            </td>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/post.js"></script>
</body>
</html>