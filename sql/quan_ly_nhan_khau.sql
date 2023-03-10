PGDMP                         {            quan_ly_nhan_khau    15.1    15.1 ,    3           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            4           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            5           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            6           1262    40968    quan_ly_nhan_khau    DATABASE     ?   CREATE DATABASE quan_ly_nhan_khau WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 !   DROP DATABASE quan_ly_nhan_khau;
                postgres    false            ?            1259    40986    ho_khau    TABLE       CREATE TABLE public.ho_khau (
    id integer NOT NULL,
    mahokhau character varying(100),
    idchuho integer,
    makhuvuc character varying(100),
    diachi character varying(100),
    ngaylap date,
    ngaychuyendi date,
    lydochuyen text,
    nguoithuchien integer
);
    DROP TABLE public.ho_khau;
       public         heap    postgres    false            ?            1259    41215    ho_khau_id_seq    SEQUENCE     ?   ALTER TABLE public.ho_khau ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ho_khau_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            ?            1259    41014 	   nhan_khau    TABLE     ?  CREATE TABLE public.nhan_khau (
    id integer NOT NULL,
    manhankhau character varying(100),
    hoten character varying(100),
    bietdanh character varying(100),
    namsinh date,
    gioitinh character varying(100),
    noisinh character varying(100),
    nguyenquan character varying(100),
    dantoc character varying(100),
    tongiao character varying(100),
    quoctich character varying(100),
    sohochieu character varying(100),
    noithuongtru character varying(100),
    diachihiennay character varying(100),
    trinhdohocvan character varying(100),
    ngaychuyenden date,
    lydochuyenden character varying(100),
    ngaychuyendi date,
    lydochuyendi character varying(100),
    diachimoi character varying(100),
    ngaytao date,
    idnguoitao integer,
    ngayxoa date,
    idnguoixoa integer,
    lydoxoa character varying(100),
    ghichu character varying(100),
    tcc character varying,
    lienhe character varying
);
    DROP TABLE public.nhan_khau;
       public         heap    postgres    false            ?            1259    41212    nhan_khau_id_seq    SEQUENCE     ?   ALTER TABLE public.nhan_khau ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.nhan_khau_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            ?            1259    41029    tam_tru    TABLE     ?   CREATE TABLE public.tam_tru (
    id integer NOT NULL,
    idnhankhau integer,
    magiaytamtru character varying(100),
    sodienthoainguoidangky character varying(100),
    tungay date NOT NULL,
    denngay date NOT NULL,
    lydo text NOT NULL
);
    DROP TABLE public.tam_tru;
       public         heap    postgres    false            ?            1259    41213    tam_tru_id_seq    SEQUENCE     ?   ALTER TABLE public.tam_tru ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tam_tru_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            ?            1259    41034    tam_vang    TABLE     ?   CREATE TABLE public.tam_vang (
    id integer NOT NULL,
    idnhankhau integer,
    magiaytamvang character varying(100),
    noitamtru character varying(100),
    tungay date,
    denngay date,
    lydo character varying(100)
);
    DROP TABLE public.tam_vang;
       public         heap    postgres    false            ?            1259    41214    tam_vang_id_seq    SEQUENCE     ?   ALTER TABLE public.tam_vang ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tam_vang_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            ?            1259    41037    thanh_vien_cua_ho    TABLE     ?   CREATE TABLE public.thanh_vien_cua_ho (
    idnhankhau integer NOT NULL,
    idhokhau integer NOT NULL,
    quanhevoichuho character varying(100)
);
 %   DROP TABLE public.thanh_vien_cua_ho;
       public         heap    postgres    false            ?            1259    41043    users    TABLE        CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(100),
    passwd character varying(100)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    41204    xoa_nhan_khau    TABLE       CREATE TABLE public.xoa_nhan_khau (
    "ID" integer NOT NULL,
    sogiay character varying,
    hoten character varying,
    namsinh timestamp with time zone,
    gioitinh character varying,
    ngayxoa timestamp with time zone,
    lydo character varying
);
 !   DROP TABLE public.xoa_nhan_khau;
       public         heap    postgres    false            ?            1259    41203    xoa_nhan_khau_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."xoa_nhan_khau_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."xoa_nhan_khau_ID_seq";
       public          postgres    false    221            7           0    0    xoa_nhan_khau_ID_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."xoa_nhan_khau_ID_seq" OWNED BY public.xoa_nhan_khau."ID";
          public          postgres    false    220            ?           2604    41207    xoa_nhan_khau ID    DEFAULT     x   ALTER TABLE ONLY public.xoa_nhan_khau ALTER COLUMN "ID" SET DEFAULT nextval('public."xoa_nhan_khau_ID_seq"'::regclass);
 A   ALTER TABLE public.xoa_nhan_khau ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    220    221    221            %          0    40986    ho_khau 
   TABLE DATA           |   COPY public.ho_khau (id, mahokhau, idchuho, makhuvuc, diachi, ngaylap, ngaychuyendi, lydochuyen, nguoithuchien) FROM stdin;
    public          postgres    false    214   c8       &          0    41014 	   nhan_khau 
   TABLE DATA           K  COPY public.nhan_khau (id, manhankhau, hoten, bietdanh, namsinh, gioitinh, noisinh, nguyenquan, dantoc, tongiao, quoctich, sohochieu, noithuongtru, diachihiennay, trinhdohocvan, ngaychuyenden, lydochuyenden, ngaychuyendi, lydochuyendi, diachimoi, ngaytao, idnguoitao, ngayxoa, idnguoixoa, lydoxoa, ghichu, tcc, lienhe) FROM stdin;
    public          postgres    false    215   ?8       '          0    41029    tam_tru 
   TABLE DATA           n   COPY public.tam_tru (id, idnhankhau, magiaytamtru, sodienthoainguoidangky, tungay, denngay, lydo) FROM stdin;
    public          postgres    false    216   ;9       (          0    41034    tam_vang 
   TABLE DATA           c   COPY public.tam_vang (id, idnhankhau, magiaytamvang, noitamtru, tungay, denngay, lydo) FROM stdin;
    public          postgres    false    217   X9       )          0    41037    thanh_vien_cua_ho 
   TABLE DATA           Q   COPY public.thanh_vien_cua_ho (idnhankhau, idhokhau, quanhevoichuho) FROM stdin;
    public          postgres    false    218   u9       *          0    41043    users 
   TABLE DATA           5   COPY public.users (id, username, passwd) FROM stdin;
    public          postgres    false    219   ?9       ,          0    41204    xoa_nhan_khau 
   TABLE DATA           ^   COPY public.xoa_nhan_khau ("ID", sogiay, hoten, namsinh, gioitinh, ngayxoa, lydo) FROM stdin;
    public          postgres    false    221   ?9       8           0    0    ho_khau_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.ho_khau_id_seq', 3, true);
          public          postgres    false    225            9           0    0    nhan_khau_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.nhan_khau_id_seq', 5, true);
          public          postgres    false    222            :           0    0    tam_tru_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.tam_tru_id_seq', 1, false);
          public          postgres    false    223            ;           0    0    tam_vang_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tam_vang_id_seq', 1, false);
          public          postgres    false    224            <           0    0    xoa_nhan_khau_ID_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."xoa_nhan_khau_ID_seq"', 35, true);
          public          postgres    false    220            ?           2606    41063    ho_khau ho_khau_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.ho_khau
    ADD CONSTRAINT ho_khau_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.ho_khau DROP CONSTRAINT ho_khau_pkey;
       public            postgres    false    214            ?           2606    41077    nhan_khau nhan_khau_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_pkey;
       public            postgres    false    215            ?           2606    41083    tam_tru tam_tru_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tam_tru
    ADD CONSTRAINT tam_tru_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tam_tru DROP CONSTRAINT tam_tru_pkey;
       public            postgres    false    216            ?           2606    41085    tam_vang tam_vang_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tam_vang
    ADD CONSTRAINT tam_vang_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tam_vang DROP CONSTRAINT tam_vang_pkey;
       public            postgres    false    217            ?           2606    41087 (   thanh_vien_cua_ho thanh_vien_cua_ho_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_pkey PRIMARY KEY (idnhankhau, idhokhau);
 R   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_pkey;
       public            postgres    false    218    218            ?           2606    41091    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    219            ?           2606    41211     xoa_nhan_khau xoa_nhan_khau_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.xoa_nhan_khau
    ADD CONSTRAINT xoa_nhan_khau_pkey PRIMARY KEY ("ID");
 J   ALTER TABLE ONLY public.xoa_nhan_khau DROP CONSTRAINT xoa_nhan_khau_pkey;
       public            postgres    false    221            ?           2606    41117    ho_khau ho_khau_ibfk_1    FK CONSTRAINT     y   ALTER TABLE ONLY public.ho_khau
    ADD CONSTRAINT ho_khau_ibfk_1 FOREIGN KEY (idchuho) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.ho_khau DROP CONSTRAINT ho_khau_ibfk_1;
       public          postgres    false    214    215    3205            ?           2606    41167    nhan_khau nhan_khau_ibfk_1    FK CONSTRAINT     |   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_ibfk_1 FOREIGN KEY (idnguoitao) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_ibfk_1;
       public          postgres    false    219    3213    215            ?           2606    41172    nhan_khau nhan_khau_ibfk_2    FK CONSTRAINT     |   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_ibfk_2 FOREIGN KEY (idnguoixoa) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_ibfk_2;
       public          postgres    false    3213    215    219            ?           2606    41177    tam_tru tam_tru_ibfk_1    FK CONSTRAINT     |   ALTER TABLE ONLY public.tam_tru
    ADD CONSTRAINT tam_tru_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.tam_tru DROP CONSTRAINT tam_tru_ibfk_1;
       public          postgres    false    216    215    3205            ?           2606    41182    tam_vang tam_vang_ibfk_1    FK CONSTRAINT     ~   ALTER TABLE ONLY public.tam_vang
    ADD CONSTRAINT tam_vang_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 B   ALTER TABLE ONLY public.tam_vang DROP CONSTRAINT tam_vang_ibfk_1;
       public          postgres    false    217    3205    215            ?           2606    41187 *   thanh_vien_cua_ho thanh_vien_cua_ho_ibfk_1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 T   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_ibfk_1;
       public          postgres    false    215    218    3205            ?           2606    41192 *   thanh_vien_cua_ho thanh_vien_cua_ho_ibfk_2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_ibfk_2 FOREIGN KEY (idhokhau) REFERENCES public.ho_khau(id);
 T   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_ibfk_2;
       public          postgres    false    214    218    3203            %   :   x?3?t?500?4????~?{??????]?3|39???u?t??`????? ???      &   ~   x?3????)z?ky????-y?
??y ACKsC]#]CN??\?yg??!?? NC#cS3sKN.$C2??V?O??h?????????H?I?????W?+?t?uQ=E?1z\\\ i?R?      '      x?????? ? ?      (      x?????? ? ?      )      x?3?4?t???2?aw/?????? <5e      *      x?3?LL????4?????? K0      ,      x?????? ? ?     