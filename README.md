## Instructions

(NOTE: this is just briefly TESTED)

To try it out:
- start play and go to the rest service project: ``play ";project restService;run"`` (you can do this in steps as well: play or sbt it is the same, then project restService (to go to rest service project) then run to start it.
- auto load the schemas: go to: http://localhost:9000/ and click apply
- try it out! there are 2 end points you can hit with curl:  
  - Write: ``curl -H "Content-Type:application/json" -d '{"foo":"ja", "bar":"bar1"}' http://localhost:9000/mypartialrestservice/write``
  - Read: ``curl "http://localhost:9000/mypartialrestservice/read?page=1"`` or page 0 or page 2 or whatever ;)
