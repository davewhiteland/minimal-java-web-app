Simple Java webapp example
==========================

Handy for demos, e.g., heroku deployment.

Cloned from Jasper's
[minimal-java-web-app](https://github.com/jasper-lyons/minimal-java-web-app/commits/master).

But Dave added the tapir.


To run locally
---------------

Assuming you've got
[Java](https://www.oracle.com/java/) and 
[Maven](https://maven.apache.org/what-is-maven.html)
available:

* `mvn package`
* `PORT=8080 java -classpath target/hello-world-0.0.0.jar Http`

Then hit it on port `8080` (because that was the `PORT` set when
you ran it).

Ctl-C to stop the process running.

To deploy to Heroku
-------------------

This is a super-summary of
[Heroku's Java app instructions](https://devcenter.heroku.com/articles/getting-started-with-java).

Assuming you've installed the 
[Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli):

Go into the app directory:

* `heroku create`
* `git push heroku master`
* `heroku ps:scale web=1`
* `heroku open`

...that last command should throw open a browser with the URL of
the Java webapp that's now running on the Heroku server. Nice!

Watch the hits pour in with:

* `heroku logs --tail`


