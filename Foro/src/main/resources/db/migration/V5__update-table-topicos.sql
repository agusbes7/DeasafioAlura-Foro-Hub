ALTER TABLE topicos
ADD COLUMN curso_id BIGINT,
ADD COLUMN autor_id BIGINT,
ADD CONSTRAINT fk_topicos_curso
    FOREIGN KEY (curso_id) REFERENCES cursos(id),
ADD CONSTRAINT fk_topicos_autor
    FOREIGN KEY (autor_id) REFERENCES usuarios(id);

