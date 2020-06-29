# generate-entity-cli
Gera uma entidade de uma determinada table do banco de dados Oracle

## Como utilizar


### NAME
        create - Create new entity from oracle table 
        ex: (create --schema amdba --username admin --password adminsystem --sid xe -table MEVU_CTRT -server localhost --classname Contrato)

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
