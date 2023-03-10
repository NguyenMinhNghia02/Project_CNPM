PGDMP                         {            quan_ly_nha_van_hoa    15.1    15.1 E    Q           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            R           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            S           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            T           1262    16398    quan_ly_nha_van_hoa    DATABASE     ?   CREATE DATABASE quan_ly_nha_van_hoa WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 #   DROP DATABASE quan_ly_nha_van_hoa;
                postgres    false            ?            1259    16399    deleteditem    TABLE     ?   CREATE TABLE public.deleteditem (
    delete_id integer NOT NULL,
    item_id integer NOT NULL,
    reason character varying(255) NOT NULL,
    item_number integer NOT NULL,
    date timestamp with time zone
);
    DROP TABLE public.deleteditem;
       public         heap    postgres    false            ?            1259    16402    deleteditem_delete_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.deleteditem_delete_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.deleteditem_delete_id_seq;
       public          postgres    false    214            U           0    0    deleteditem_delete_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.deleteditem_delete_id_seq OWNED BY public.deleteditem.delete_id;
          public          postgres    false    215            ?            1259    16403    deleteditem_item_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.deleteditem_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.deleteditem_item_id_seq;
       public          postgres    false    214            V           0    0    deleteditem_item_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.deleteditem_item_id_seq OWNED BY public.deleteditem.item_id;
          public          postgres    false    216            ?            1259    16404    infraregistered    TABLE     ?   CREATE TABLE public.infraregistered (
    infra_id integer NOT NULL,
    user_id integer NOT NULL,
    event_no integer NOT NULL,
    da_tra integer DEFAULT 0 NOT NULL
);
 #   DROP TABLE public.infraregistered;
       public         heap    postgres    false            ?            1259    16407    infrastructure    TABLE     ?   CREATE TABLE public.infrastructure (
    infra_id integer NOT NULL,
    infra_name character varying(255) NOT NULL,
    reason character varying(255)
);
 "   DROP TABLE public.infrastructure;
       public         heap    postgres    false            ?            1259    16412    infrastructure_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.infrastructure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.infrastructure_id_seq;
       public          postgres    false    218            W           0    0    infrastructure_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.infrastructure_id_seq OWNED BY public.infrastructure.infra_id;
          public          postgres    false    219            ?            1259    16413    item    TABLE     ?   CREATE TABLE public.item (
    item_id integer NOT NULL,
    item_name character varying(255) NOT NULL,
    item_quantity integer NOT NULL
);
    DROP TABLE public.item;
       public         heap    postgres    false            ?            1259    16416    item_id_seq    SEQUENCE     t   CREATE SEQUENCE public.item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.item_id_seq;
       public          postgres    false    220            X           0    0    item_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.item_id_seq OWNED BY public.item.item_id;
          public          postgres    false    221            ?            1259    16417    itemregistered    TABLE     ?   CREATE TABLE public.itemregistered (
    item_id integer NOT NULL,
    user_id integer NOT NULL,
    event_no integer NOT NULL,
    item_number integer NOT NULL,
    da_tra integer DEFAULT 0 NOT NULL
);
 "   DROP TABLE public.itemregistered;
       public         heap    postgres    false            ?            1259    16420    money    TABLE     ?   CREATE TABLE public.money (
    money_id integer NOT NULL,
    item_id integer NOT NULL,
    item_number integer NOT NULL,
    date date NOT NULL,
    reason character varying(255)
);
    DROP TABLE public.money;
       public         heap    postgres    false            ?            1259    16423    money_money_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.money_money_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.money_money_id_seq;
       public          postgres    false    223            Y           0    0    money_money_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.money_money_id_seq OWNED BY public.money.money_id;
          public          postgres    false    224            ?            1259    16424 	   registers    TABLE       CREATE TABLE public.registers (
    user_id integer NOT NULL,
    user_name character varying(255) NOT NULL,
    user_address character varying(255),
    user_phone character varying(255) NOT NULL,
    fee_register integer,
    cccd character varying(255) NOT NULL
);
    DROP TABLE public.registers;
       public         heap    postgres    false            ?            1259    16429    registers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.registers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.registers_id_seq;
       public          postgres    false    225            Z           0    0    registers_id_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.registers_id_seq OWNED BY public.registers.user_id;
          public          postgres    false    226            ?            1259    16430    schedule    TABLE     ?   CREATE TABLE public.schedule (
    event_no integer NOT NULL,
    time_start timestamp with time zone NOT NULL,
    time_end timestamp with time zone NOT NULL,
    real_time_end timestamp with time zone
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            ?            1259    16433    schedule_id_seq    SEQUENCE     x   CREATE SEQUENCE public.schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.schedule_id_seq;
       public          postgres    false    227            [           0    0    schedule_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.schedule_id_seq OWNED BY public.schedule.event_no;
          public          postgres    false    228            ?            1259    16434    users    TABLE        CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(100),
    passwd character varying(100)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?           2604    16437    deleteditem delete_id    DEFAULT     ~   ALTER TABLE ONLY public.deleteditem ALTER COLUMN delete_id SET DEFAULT nextval('public.deleteditem_delete_id_seq'::regclass);
 D   ALTER TABLE public.deleteditem ALTER COLUMN delete_id DROP DEFAULT;
       public          postgres    false    215    214            ?           2604    16438    deleteditem item_id    DEFAULT     z   ALTER TABLE ONLY public.deleteditem ALTER COLUMN item_id SET DEFAULT nextval('public.deleteditem_item_id_seq'::regclass);
 B   ALTER TABLE public.deleteditem ALTER COLUMN item_id DROP DEFAULT;
       public          postgres    false    216    214            ?           2604    16439    infrastructure infra_id    DEFAULT     |   ALTER TABLE ONLY public.infrastructure ALTER COLUMN infra_id SET DEFAULT nextval('public.infrastructure_id_seq'::regclass);
 F   ALTER TABLE public.infrastructure ALTER COLUMN infra_id DROP DEFAULT;
       public          postgres    false    219    218            ?           2604    16440    item item_id    DEFAULT     g   ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_id_seq'::regclass);
 ;   ALTER TABLE public.item ALTER COLUMN item_id DROP DEFAULT;
       public          postgres    false    221    220            ?           2604    16441    money money_id    DEFAULT     p   ALTER TABLE ONLY public.money ALTER COLUMN money_id SET DEFAULT nextval('public.money_money_id_seq'::regclass);
 =   ALTER TABLE public.money ALTER COLUMN money_id DROP DEFAULT;
       public          postgres    false    224    223            ?           2604    16442    registers user_id    DEFAULT     q   ALTER TABLE ONLY public.registers ALTER COLUMN user_id SET DEFAULT nextval('public.registers_id_seq'::regclass);
 @   ALTER TABLE public.registers ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    226    225            ?           2604    16443    schedule event_no    DEFAULT     p   ALTER TABLE ONLY public.schedule ALTER COLUMN event_no SET DEFAULT nextval('public.schedule_id_seq'::regclass);
 @   ALTER TABLE public.schedule ALTER COLUMN event_no DROP DEFAULT;
       public          postgres    false    228    227            ?          0    16399    deleteditem 
   TABLE DATA           T   COPY public.deleteditem (delete_id, item_id, reason, item_number, date) FROM stdin;
    public          postgres    false    214   ?O       B          0    16404    infraregistered 
   TABLE DATA           N   COPY public.infraregistered (infra_id, user_id, event_no, da_tra) FROM stdin;
    public          postgres    false    217   P       C          0    16407    infrastructure 
   TABLE DATA           F   COPY public.infrastructure (infra_id, infra_name, reason) FROM stdin;
    public          postgres    false    218   ;P       E          0    16413    item 
   TABLE DATA           A   COPY public.item (item_id, item_name, item_quantity) FROM stdin;
    public          postgres    false    220   Q       G          0    16417    itemregistered 
   TABLE DATA           Y   COPY public.itemregistered (item_id, user_id, event_no, item_number, da_tra) FROM stdin;
    public          postgres    false    222   ?Q       H          0    16420    money 
   TABLE DATA           M   COPY public.money (money_id, item_id, item_number, date, reason) FROM stdin;
    public          postgres    false    223   R       J          0    16424 	   registers 
   TABLE DATA           e   COPY public.registers (user_id, user_name, user_address, user_phone, fee_register, cccd) FROM stdin;
    public          postgres    false    225   ?R       L          0    16430    schedule 
   TABLE DATA           Q   COPY public.schedule (event_no, time_start, time_end, real_time_end) FROM stdin;
    public          postgres    false    227   ?S       N          0    16434    users 
   TABLE DATA           5   COPY public.users (id, username, passwd) FROM stdin;
    public          postgres    false    229   ?U       \           0    0    deleteditem_delete_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.deleteditem_delete_id_seq', 16, true);
          public          postgres    false    215            ]           0    0    deleteditem_item_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.deleteditem_item_id_seq', 1, false);
          public          postgres    false    216            ^           0    0    infrastructure_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.infrastructure_id_seq', 12, true);
          public          postgres    false    219            _           0    0    item_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.item_id_seq', 14, true);
          public          postgres    false    221            `           0    0    money_money_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.money_money_id_seq', 14, true);
          public          postgres    false    224            a           0    0    registers_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.registers_id_seq', 58, true);
          public          postgres    false    226            b           0    0    schedule_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.schedule_id_seq', 78, true);
          public          postgres    false    228            ?           2606    40966    itemregistered chk_datra    CHECK CONSTRAINT     j   ALTER TABLE public.itemregistered
    ADD CONSTRAINT chk_datra CHECK ((da_tra <= item_number)) NOT VALID;
 =   ALTER TABLE public.itemregistered DROP CONSTRAINT chk_datra;
       public          postgres    false    222    222    222    222            ?           2606    40963    registers cmt3 
   CONSTRAINT     I   ALTER TABLE ONLY public.registers
    ADD CONSTRAINT cmt3 UNIQUE (cccd);
 8   ALTER TABLE ONLY public.registers DROP CONSTRAINT cmt3;
       public            postgres    false    225            ?           2606    16445    deleteditem deleteditem_pk 
   CONSTRAINT     _   ALTER TABLE ONLY public.deleteditem
    ADD CONSTRAINT deleteditem_pk PRIMARY KEY (delete_id);
 D   ALTER TABLE ONLY public.deleteditem DROP CONSTRAINT deleteditem_pk;
       public            postgres    false    214            ?           2606    16447 "   infraregistered infraregistered_pk 
   CONSTRAINT     y   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_pk PRIMARY KEY (infra_id, user_id, event_no);
 L   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_pk;
       public            postgres    false    217    217    217            ?           2606    16449     infrastructure infrastructure_pk 
   CONSTRAINT     d   ALTER TABLE ONLY public.infrastructure
    ADD CONSTRAINT infrastructure_pk PRIMARY KEY (infra_id);
 J   ALTER TABLE ONLY public.infrastructure DROP CONSTRAINT infrastructure_pk;
       public            postgres    false    218            ?           2606    16451    item item_pk 
   CONSTRAINT     O   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pk PRIMARY KEY (item_id);
 6   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pk;
       public            postgres    false    220            ?           2606    16453     itemregistered itemregistered_pk 
   CONSTRAINT     v   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_pk PRIMARY KEY (item_id, user_id, event_no);
 J   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_pk;
       public            postgres    false    222    222    222            ?           2606    16455    money money_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.money
    ADD CONSTRAINT money_pk PRIMARY KEY (money_id);
 8   ALTER TABLE ONLY public.money DROP CONSTRAINT money_pk;
       public            postgres    false    223            ?           2606    16457    registers registers_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.registers
    ADD CONSTRAINT registers_pk PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.registers DROP CONSTRAINT registers_pk;
       public            postgres    false    225            ?           2606    16459    schedule schedule_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pk PRIMARY KEY (event_no);
 >   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pk;
       public            postgres    false    227            ?           2606    16461    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    229            ?           2606    41227    deleteditem fk    FK CONSTRAINT     {   ALTER TABLE ONLY public.deleteditem
    ADD CONSTRAINT fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;
 8   ALTER TABLE ONLY public.deleteditem DROP CONSTRAINT fk;
       public          postgres    false    220    3228    214            ?           2606    16467 #   infraregistered infraregistered_fk0    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk0 FOREIGN KEY (infra_id) REFERENCES public.infrastructure(infra_id);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk0;
       public          postgres    false    3226    217    218            ?           2606    16472 #   infraregistered infraregistered_fk1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk1 FOREIGN KEY (user_id) REFERENCES public.registers(user_id);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk1;
       public          postgres    false    225    217    3236            ?           2606    16477 #   infraregistered infraregistered_fk2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk2 FOREIGN KEY (event_no) REFERENCES public.schedule(event_no);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk2;
       public          postgres    false    217    3238    227            ?           2606    16482 !   itemregistered itemregistered_fk0    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk0 FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk0;
       public          postgres    false    222    220    3228            ?           2606    16487 !   itemregistered itemregistered_fk1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk1 FOREIGN KEY (user_id) REFERENCES public.registers(user_id);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk1;
       public          postgres    false    222    3236    225            ?           2606    16492 !   itemregistered itemregistered_fk2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk2 FOREIGN KEY (event_no) REFERENCES public.schedule(event_no);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk2;
       public          postgres    false    222    227    3238            ?           2606    16497    money money_fk1    FK CONSTRAINT     r   ALTER TABLE ONLY public.money
    ADD CONSTRAINT money_fk1 FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 9   ALTER TABLE ONLY public.money DROP CONSTRAINT money_fk1;
       public          postgres    false    223    3228    220            ?   e   x?34?44?4NC#N##c]#]Cc+0?60?24?4?4R?9? W!?ᮥ%???j?Ḽ????M???M9?8?/??g??L'?\jb???? ?H!?      B      x?3?4B.#(m?i?\&P:F??? Tc      C   ?   x?3??8?)/]?83/C!#?ᮅ%
??y震? ????T?K??7Y!???<???????2/P(;Ҝ?sx!?̘??????????ш$????$i4?i4"ѩ???9???4?Zr?$?o?#????F?Ա??$chs@?ᅕ
%???ep?d^??eh?iEsI???qqq A?      E   ?   x?=?-?@???S?	Hw??ǂ@!H
E[A	??JnP??? h\W ??{??0?}_??h?mh^0Z??lM1F??y܉?Ep?T`??m?[??ôM????C?????ʂ;l7?©??P???;?|?ZĤ"L|]r???XnֈH?P??f#Z?20=?b????S[?2??}????????"? ??Fy      G   0   x?=ȱ  ??Z?;?,??s ?^&?.??l??܇?֯=$??      H   ?   x?3?4?442?4202?50?54?<<%/]????L????{?B/?S(y?k;P</????#?y
??rqq??݄?h ??M9M??l?i?I???9?9?Z??m?irru[rZ??<͆?0o????\?&?$?"qx1? ?=... ?X?u      J     x??Q?J1?g?b??Kv??Wz6)tA\??F?X?	*na-b%(Vv*?p(ں)s?y'j?`?}????'?h???d?/{iZҝ?????5	Z]?ᾣ-ooh^NFt???Ő??h??8??ʹ#?????v02?UQV`R??ݒv{?? ???3??B??N?0??{??n?Kj܃??#??'Ɛ|̡?b??}?9????Z+&??@?@¼?1???<.?hh?G`??22c)آ*#?n?S?4?????&QU8ޞ????0E?k,???D??c??      L   ?  x???[r?0E??U???????
??:j;?RHc"3×?=H?FV????x&8??????S?=??>????	???ǋ?3ԓ??
S ֨??"_?P??o???`ave?Y?ϒKZ@\Y?t??>1@쨴?zJ?????_hK????)?4???{??IM>?aphС!????65????;|???????|p????1d??M?????8| (?t??M?c??*?zn??+??c?%`?j}#???+?Z8sg??jXT?B??5M?ŵ???۞?n?p??u???????i??+??3??p??Gͱ??^mm??>?X?p
H?&S,Զ?*?5?:??_?`??U?Ay??u????f??Rue?,I?r??n??_
?Q????nㄛJ?	9eі9?pVc?$I???+Ӽɬ?1?Z?.??]?0??e? M?=      N      x?3?LL????4?????? K0     