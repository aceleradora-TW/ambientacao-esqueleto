CREATE TABLE lista_produtos (
    id serial primary key,
    id_produto integer,
    id_lista integer,

    contraint fk_produto foreign key (id_produto) references produto(id),
    contraint fk_lista foreign key (id_lista) references lista(id)
);