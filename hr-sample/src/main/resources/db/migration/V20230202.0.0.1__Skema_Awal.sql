create table public.employees
(
    id                  varchar(36) not null ,
    first_name          varchar(150) default null,
    last_name           varchar(150),
    email               varchar(50) not null ,
    phone_number        varchar(20) default null,
    hire_date           DATE,
    salary              DECIMAL (8, 2) not null ,
    id_job              varchar(36) not null ,
    id_manager          varchar(36) not null ,
    id_department       varchar(36) not null ,
    primary key (id)
);

create table public.jobs
(
    id                  varchar(36) not null ,
    job_title           varchar(36) not null ,
    min_salary          DECIMAL(8, 2) default null,
    max_salary          DECIMAL(8, 2) default null,
    primary key (id)
);

create table public.departments
(
    id                  varchar(36) not null ,
    department_name     varchar(30) not null ,
    primary key (id)
);

create table public.dependents
(
    id                  varchar(36) not null ,
    first_name          varchar(150) not null ,
    last_name           varchar(150) default null,
    relationship        varchar(25) not null ,
    id_employee         varchar(36) not null ,
    primary key (id)
);

alter table if exists public.employees
    add constraint FKtestforeignkeyfromjobs
        foreign key (id_job)
            references public.jobs;

alter table if exists public.employees
    add constraint FKtestforeignkeyfromemployees
        foreign key (id_manager)
            references public.employees;

alter table if exists public.employees
    add constraint FKtestforeignkeyfromdepartment
        foreign key (id_department)
            references public.departments;

alter table if exists public.dependents
    add constraint FKtestforeignkeyfromemployees
        foreign key (id_employee)
            references public.employees;