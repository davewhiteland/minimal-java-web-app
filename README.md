Simple Java webapp example
==========================

This is a very simple web application in Java: it runs a little webserver
that returns one single web page.

It's handy for demos, e.g., heroku deployment.

Cloned from Jasper's
[minimal-java-web-app](https://github.com/jasper-lyons/minimal-java-web-app/commits/master).

But Dave added the tapir.


To run locally
---------------

You'll need recent version of
[Java](https://www.oracle.com/java/) 
(because it's a Java application that needs to be compiled)
and 
[Maven](https://maven.apache.org/what-is-maven.html)
(to build the compiled class files into an application)
installed.

Go into the app directory and do:

* `mvn package`
* `PORT=8080 java -classpath target/hello-world-0.0.0.jar Http`

Then hit it in a browser at `http://localhost/8080`.

Ctl-C to stop the process running.


To deploy to Heroku
-------------------

You must have [Git](https://git-scm.com) installed, because you deploy your
files to Heroku by _pushing_ to a remote repo up there.

[Heroku](https://devcenter.heroku.com) is basically a remote repo that "knows"
how to run your application (because you've included a `Procfile` that tells it
what type processes to run and how, and also because it's familiar with a lot
of established frameworks).

This is a super-summary of
[Heroku's Java app instructions](https://devcenter.heroku.com/articles/getting-started-with-java).

You need to install
[Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli),
and authenticate it: 

* `heroku login`

Once you're authenticated, go into the app directory and do:

* `heroku create`
* `git push heroku master`
* `heroku ps:scale web=1`
* `heroku open`

...that last command should throw open a browser with the URL of the Java
webapp that's now running on the Heroku server. Nice!

Watch the hits pour in with:

* `heroku logs --tail`


