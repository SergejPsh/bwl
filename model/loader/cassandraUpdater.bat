@echo off

cd C:\Users\Sergey.Pshetotskiy\IdeaProjects\bwl\model\loader
cmd.exe /k sql-loader.bat "C:\apache-cassandra-3.11.3" "C:\Users\Sergey.Pshetotskiy\IdeaProjects\bwl\model\loader\sql"
CMD /K
CD C:\