#REST Server

Для запуску jetty виконайте команду в терміналі:

`mvn jetty:run`

Далі перейдіть за посиланням
<a href="http://localhost:8080/hello">localhost:8080/hello</a>
Ви повині побачити щось на зразок цього:

`[{"id":1,"login":"zccmj","password":"password","registrationDate":1437488800540,"role":"role"}]`

Для зупинки jetty виконайте команду в терміналі:

`mvn jetty:stop`
