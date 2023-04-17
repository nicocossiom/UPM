Diseño de GEOETSIINF
===

Modelos
===
Usuario:
- first_name 
- last_name
- user_name
- email
- postal_code

Tesoro:
- treasure_name
- coordinate_x
- coordinate_y
- treasure_id
- terrain_type
- difficulty
- hint
- size
- date_added

Operaciones de usuario
===
- POST: /users
- GET: /users/{user_id}
- PUT: /users/{user_id}
- DELETE: /users/{user_id}
- GET: /users?name="Mar"    `//Patrón de nombre`

Operaciones de tesoros
===
- POST: /users/{user_id}/treasures
- PUT: /users/{user_id}/treasures/{treasure_id}
- DELETE: /users/{user_id}/treasures/{treasure_id}
- GET: /users/{user_id}/treasures?before=1/1/1991    `//Anteriores a fecha`
- GET: /users/{user_id}/treasures?start=treasure1&count=treasure10   `//Mostar 10 a partir del indice 1`
- GET: /users/{user_id}/treasures?level=easy   `//Filtrar por atributos del tesoro`
- GET: /treasures?coordx=1&coordy=2&before=1/1/1991 `//Cercanos a (X,Y) y anteriores a fecha`
- GET: /treasures?coordx=1&coordy=2&start=1&count=10 `//Cercanos a (X,Y) y mostar 10 a partir del indice 1`

Operaciones de histórico
===
- PUT: /users/{user_id}/found/{treasure_id}
- GET: /users/{user_id}/found?before=1/1/1991    `//Anteriores a fecha`
- GET: /users/{user_id}/found?start=treasure1&count=treasure10   `//Mostar 10 a partir del indice 1`
- GET: /users/{user_id}/found?level=easy   `//Filtrar por atributos del tesoro`


Operaciones de amigos
===
- PUT: /users/{user_id}/friends/{user_id}
- GET: /users/{user_id}/friends?name="Mar"   `//Patrón de nombre`
- GET: /users/{user_id}/friends?start=friend1&count=friend10   `//Mostar 10 a partir del indice 1`
- DELETE: /users/{user_id}/friends/{user_id}

Otras operaciones
===
- GET: /users/{user_id}/summary  `//Recurso compuesto con los datos de usuario, número de terosos encontrados (URIs), últimos 5 tesoros encontrados, número de amigos y número de tesoros añadidos`