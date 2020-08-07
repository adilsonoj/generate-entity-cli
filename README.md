[![GitHub license](https://img.shields.io/github/license/adilsonoj/generate-entity-cli)](https://github.com/adilsonoj/generate-entity-cli/blob/master/LICENSE)

# generate-entity-cli
Gera uma entidade de uma determinada tabela do banco de dados Oracle

## Download
[generateentity-0.0.1.jar](https://github-production-registry-package-file-4f11e5.s3.amazonaws.com/275895912/aa351e00-d8a6-11ea-8dc4-8d87dcf42d31?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20200807%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200807T150906Z&X-Amz-Expires=300&X-Amz-Signature=bb05fed14bf6293aa79adfc9c7da5b0f2e03114b577560ca50f63bbb30ccc1b6&X-Amz-SignedHeaders=host&actor_id=0&repo_id=0&response-content-disposition=filename%3Dgenerateentity-0.0.1.jar&response-content-type=application%2Foctet-stream)

## Como utilizar

### NAME
        create - Create new entity from oracle table 
        ex: (create --schema <schema> --username <user name> --password <password> --sid <sid> --table <table name> --server <uri> --classname <class name>)

### SYNOPSYS
        create [-S] string  [-U] string  [-P] string  [-T] string  [-SE] string  [-SI] string  [-CN] string  [[--pack] string]  

### OPTIONS
        -S or --schema  string

        -U or --username  string

        -P or --password  string
        
        -T or --table  string

        -SE or --server  string

        -SI or --sid  string

        -CN or --classname  string

        --pack  string

                [Optional, default = br.mil.mar.amrj.modelo]
