#!/usr/bin/env sh

curl -H "Content-Type: application/json" -X POST -d '{"cnt":10, "name":"duanxin", "birthday":"1999-01-01", "gender":1, "chatNumber":"10086", "city":"cd", "dsc":"dsc"}' "http://localhost:8080/friendbox/createBox.json"


