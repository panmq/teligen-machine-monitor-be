提供了三种类型URL： 
1，查看系统的运行情况：http://localhost:7788/teligen-machine-monitor-be/system/
2，JPA API的REST服务：http://localhost:7788/teligen-machine-monitor-be/jpa/
3，REST Service URL：http://localhost:7788/teligen-machine-monitor-be/rest/

现提供两种数据库查询Repository:
1，JPA：适用于简单查询。但QBE查询规则支持比较弱。参考http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
2，QBE：适合于条件查询。参考https://github.com/jaxio/jpa-query-by-example。（TODO：需要检查这个项目的代码，并根据部门项目的业务场景定制合适的SearchParameters）
3，自实现JPA原生的QBE实现Specification类，但太过复杂，不推荐使用。参考http://stackoverflow.com/questions/27626825/spring-data-jpa-query-by-example

参考：
InfluxDB：https://www.influxdata.com/time-series-platform/influxdb/
Grafana：http://grafana.org/
code generation templates pack：http://www.jaxio.com/en/celerio.html

**********

启动数据库服务
cd influxdb-1.1.1-1/usr/bin
./influxd
打开数据库客户端建立数据库
cd influxdb-1.1.1-1/usr/bin
./influx
create database monitordb

配置Grafana
cd grafana-4.0.1-1480694114
cp conf/sample.ini conf/custom.ini
启动Grafana服务
./bin/grafana-server
