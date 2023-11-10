# Integrador 3

### Endpoints

POST y GET /estudiantes -> creacion (POST) de estudiante y retorna todos los estudiantes (GET)

POST /estudiantes/{dni}/enroll -> enrola un estudiante en una materia (POST)

GET /estudiantes/ByLibreta/{num_libreta} -> retorna estudiante por numero de libreta

GET /ByGenero/{genero} -> retorna estudiante(s) por genero

GET /ByCiudadAndCarrera/{carrera}/{ciudad} -> retorna estudiante(s) por carrera y ciudad

GET /carreras/SortByInscriptos -> devuelve carreras ordenados por cantidad de inscriptos

GET /carreras/reporte -> reporte de carreras