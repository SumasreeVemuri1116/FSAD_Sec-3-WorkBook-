
FULLSTACK DEPLOYMENT STEPS

1. Put your Spring Boot JAR inside backend/app.jar
2. Run:
   cd backend
   java -jar app.jar

3. Copy frontend/build to nginx root:
   sudo cp -r build/* /var/www/html/

4. Restart nginx:
   sudo systemctl restart nginx

5. Open browser:
   http://localhost
