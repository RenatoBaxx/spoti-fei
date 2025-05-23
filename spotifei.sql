PGDMP  )                    }            alunos    17.4    17.4 <    5           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            6           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            7           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            8           1262    16388    alunos    DATABASE     }   CREATE DATABASE alunos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE alunos;
                     postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                     pg_database_owner    false            9           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                        pg_database_owner    false    4            �            1259    16390    aluno    TABLE     �   CREATE TABLE public.aluno (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(100) NOT NULL
);
    DROP TABLE public.aluno;
       public         heap r       postgres    false    4            �            1259    16389    aluno_id_seq    SEQUENCE     �   CREATE SEQUENCE public.aluno_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.aluno_id_seq;
       public               postgres    false    4    218            :           0    0    aluno_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.aluno_id_seq OWNED BY public.aluno.id;
          public               postgres    false    217            �            1259    16399    artista    TABLE     c   CREATE TABLE public.artista (
    id integer NOT NULL,
    nome character varying(100) NOT NULL
);
    DROP TABLE public.artista;
       public         heap r       postgres    false    4            �            1259    16398    artista_id_seq    SEQUENCE     �   CREATE SEQUENCE public.artista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.artista_id_seq;
       public               postgres    false    220    4            ;           0    0    artista_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.artista_id_seq OWNED BY public.artista.id;
          public               postgres    false    219            �            1259    16418    curtida    TABLE     g  CREATE TABLE public.curtida (
    id integer NOT NULL,
    id_aluno integer NOT NULL,
    id_musica integer NOT NULL,
    tipo character varying(10),
    data timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT curtida_tipo_check CHECK (((tipo)::text = ANY ((ARRAY['curtir'::character varying, 'descurtir'::character varying])::text[])))
);
    DROP TABLE public.curtida;
       public         heap r       postgres    false    4            �            1259    16417    curtida_id_seq    SEQUENCE     �   CREATE SEQUENCE public.curtida_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.curtida_id_seq;
       public               postgres    false    4    224            <           0    0    curtida_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.curtida_id_seq OWNED BY public.curtida.id;
          public               postgres    false    223            �            1259    16464    historico_buscas    TABLE     �   CREATE TABLE public.historico_buscas (
    id integer NOT NULL,
    id_aluno integer NOT NULL,
    id_musica integer NOT NULL,
    data timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 $   DROP TABLE public.historico_buscas;
       public         heap r       postgres    false    4            �            1259    16463    historico_buscas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.historico_buscas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.historico_buscas_id_seq;
       public               postgres    false    229    4            =           0    0    historico_buscas_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.historico_buscas_id_seq OWNED BY public.historico_buscas.id;
          public               postgres    false    228            �            1259    16406    musica    TABLE     �   CREATE TABLE public.musica (
    id integer NOT NULL,
    titulo character varying(100) NOT NULL,
    genero character varying(50),
    id_artista integer NOT NULL
);
    DROP TABLE public.musica;
       public         heap r       postgres    false    4            �            1259    16405    musica_id_seq    SEQUENCE     �   CREATE SEQUENCE public.musica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.musica_id_seq;
       public               postgres    false    222    4            >           0    0    musica_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.musica_id_seq OWNED BY public.musica.id;
          public               postgres    false    221            �            1259    16437    playlist    TABLE     �   CREATE TABLE public.playlist (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    id_aluno integer NOT NULL
);
    DROP TABLE public.playlist;
       public         heap r       postgres    false    4            �            1259    16436    playlist_id_seq    SEQUENCE     �   CREATE SEQUENCE public.playlist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.playlist_id_seq;
       public               postgres    false    4    226            ?           0    0    playlist_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.playlist_id_seq OWNED BY public.playlist.id;
          public               postgres    false    225            �            1259    16448    playlist_musica    TABLE     j   CREATE TABLE public.playlist_musica (
    id_playlist integer NOT NULL,
    id_musica integer NOT NULL
);
 #   DROP TABLE public.playlist_musica;
       public         heap r       postgres    false    4            t           2604    16393    aluno id    DEFAULT     d   ALTER TABLE ONLY public.aluno ALTER COLUMN id SET DEFAULT nextval('public.aluno_id_seq'::regclass);
 7   ALTER TABLE public.aluno ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            u           2604    16402 
   artista id    DEFAULT     h   ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);
 9   ALTER TABLE public.artista ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    219    220            w           2604    16421 
   curtida id    DEFAULT     h   ALTER TABLE ONLY public.curtida ALTER COLUMN id SET DEFAULT nextval('public.curtida_id_seq'::regclass);
 9   ALTER TABLE public.curtida ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    224    223    224            z           2604    16467    historico_buscas id    DEFAULT     z   ALTER TABLE ONLY public.historico_buscas ALTER COLUMN id SET DEFAULT nextval('public.historico_buscas_id_seq'::regclass);
 B   ALTER TABLE public.historico_buscas ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    229    228    229            v           2604    16409 	   musica id    DEFAULT     f   ALTER TABLE ONLY public.musica ALTER COLUMN id SET DEFAULT nextval('public.musica_id_seq'::regclass);
 8   ALTER TABLE public.musica ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    221    222    222            y           2604    16440    playlist id    DEFAULT     j   ALTER TABLE ONLY public.playlist ALTER COLUMN id SET DEFAULT nextval('public.playlist_id_seq'::regclass);
 :   ALTER TABLE public.playlist ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    225    226    226            '          0    16390    aluno 
   TABLE DATA           9   COPY public.aluno (id, nome, usuario, senha) FROM stdin;
    public               postgres    false    218   �D       )          0    16399    artista 
   TABLE DATA           +   COPY public.artista (id, nome) FROM stdin;
    public               postgres    false    220   �E       -          0    16418    curtida 
   TABLE DATA           F   COPY public.curtida (id, id_aluno, id_musica, tipo, data) FROM stdin;
    public               postgres    false    224   �E       2          0    16464    historico_buscas 
   TABLE DATA           I   COPY public.historico_buscas (id, id_aluno, id_musica, data) FROM stdin;
    public               postgres    false    229   +F       +          0    16406    musica 
   TABLE DATA           @   COPY public.musica (id, titulo, genero, id_artista) FROM stdin;
    public               postgres    false    222   8I       /          0    16437    playlist 
   TABLE DATA           6   COPY public.playlist (id, nome, id_aluno) FROM stdin;
    public               postgres    false    226   J       0          0    16448    playlist_musica 
   TABLE DATA           A   COPY public.playlist_musica (id_playlist, id_musica) FROM stdin;
    public               postgres    false    227   �J       @           0    0    aluno_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.aluno_id_seq', 12, true);
          public               postgres    false    217            A           0    0    artista_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.artista_id_seq', 4, true);
          public               postgres    false    219            B           0    0    curtida_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.curtida_id_seq', 24, true);
          public               postgres    false    223            C           0    0    historico_buscas_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.historico_buscas_id_seq', 79, true);
          public               postgres    false    228            D           0    0    musica_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.musica_id_seq', 23, true);
          public               postgres    false    221            E           0    0    playlist_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.playlist_id_seq', 14, true);
          public               postgres    false    225            ~           2606    16395    aluno aluno_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.aluno DROP CONSTRAINT aluno_pkey;
       public                 postgres    false    218            �           2606    16397    aluno aluno_usuario_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_usuario_key UNIQUE (usuario);
 A   ALTER TABLE ONLY public.aluno DROP CONSTRAINT aluno_usuario_key;
       public                 postgres    false    218            �           2606    16404    artista artista_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.artista DROP CONSTRAINT artista_pkey;
       public                 postgres    false    220            �           2606    16425    curtida curtida_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.curtida
    ADD CONSTRAINT curtida_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.curtida DROP CONSTRAINT curtida_pkey;
       public                 postgres    false    224            �           2606    16470 &   historico_buscas historico_buscas_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_pkey;
       public                 postgres    false    229            �           2606    16411    musica musica_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.musica DROP CONSTRAINT musica_pkey;
       public                 postgres    false    222            �           2606    16452 $   playlist_musica playlist_musica_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.playlist_musica
    ADD CONSTRAINT playlist_musica_pkey PRIMARY KEY (id_playlist, id_musica);
 N   ALTER TABLE ONLY public.playlist_musica DROP CONSTRAINT playlist_musica_pkey;
       public                 postgres    false    227    227            �           2606    16442    playlist playlist_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_pkey;
       public                 postgres    false    226            �           2606    16426    curtida curtida_id_aluno_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.curtida
    ADD CONSTRAINT curtida_id_aluno_fkey FOREIGN KEY (id_aluno) REFERENCES public.aluno(id);
 G   ALTER TABLE ONLY public.curtida DROP CONSTRAINT curtida_id_aluno_fkey;
       public               postgres    false    218    224    4734            �           2606    16431    curtida curtida_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.curtida
    ADD CONSTRAINT curtida_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 H   ALTER TABLE ONLY public.curtida DROP CONSTRAINT curtida_id_musica_fkey;
       public               postgres    false    4740    224    222            �           2606    16471 /   historico_buscas historico_buscas_id_aluno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_aluno_fkey FOREIGN KEY (id_aluno) REFERENCES public.aluno(id);
 Y   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_id_aluno_fkey;
       public               postgres    false    218    229    4734            �           2606    16476 0   historico_buscas historico_buscas_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 Z   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_id_musica_fkey;
       public               postgres    false    4740    222    229            �           2606    16412    musica musica_id_artista_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_id_artista_fkey FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 G   ALTER TABLE ONLY public.musica DROP CONSTRAINT musica_id_artista_fkey;
       public               postgres    false    222    4738    220            �           2606    16443    playlist playlist_id_aluno_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_id_aluno_fkey FOREIGN KEY (id_aluno) REFERENCES public.aluno(id);
 I   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_id_aluno_fkey;
       public               postgres    false    4734    218    226            �           2606    16458 .   playlist_musica playlist_musica_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist_musica
    ADD CONSTRAINT playlist_musica_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id) ON DELETE CASCADE;
 X   ALTER TABLE ONLY public.playlist_musica DROP CONSTRAINT playlist_musica_id_musica_fkey;
       public               postgres    false    4740    227    222            �           2606    16453 0   playlist_musica playlist_musica_id_playlist_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist_musica
    ADD CONSTRAINT playlist_musica_id_playlist_fkey FOREIGN KEY (id_playlist) REFERENCES public.playlist(id) ON DELETE CASCADE;
 Z   ALTER TABLE ONLY public.playlist_musica DROP CONSTRAINT playlist_musica_id_playlist_fkey;
       public               postgres    false    4744    227    226            '   �   x�U�;1��ɏ��Y��U"�6Q��8������d#�63�7��H�ӑ�I���	� ��`g,���!��4Æg&9a8��0\���.�j?P��-PzkV蒳��W+l���y�9EG��g�J��/.EǾRa�B�/����'B��6L�      )   ;   x�3��M,)M�2�tK��,HUJ-�2�JMNTHL�O�����2�t)J�N����� �~      -   L   x�3�4�4�L.-*�,�4202�50�52T00�#.�#|
,�
9SR���#�ZpZTd4� �
��=... �L&�      2   �  x�u�ۑ�*���(6�����XN�q�xjk�=��hu#rP�����c�!>QO����
�����4hJ$`�Y��D����T=11�&����C���O�Z
/D�6"w�y���eR>#�J
�S���իH��"V<��*��	�	:Q�� ��J�	�t�NC�H~�L1�Xv�!d�6�X	�����s%M"C+<��D�L/�.D�:�F�1�֑;��-�,?�*�~IVd����J��U�䕬� �>硷dEO��J]lMbO�$�y��
�Qr���W2�e"�O�|A,�dm���I�'?vb�vCb�o@���$CI�
�'��Hwu5����.5�eGQZ�Q�o�|�>�������(�:�	k��G�
�g�����jP����B8��@����/R	jG��4A<Ī�h�:���y>�����|��`�g?TCE�q�EvBN�N�H����En~.D�G���[%�ͨ�����I��N�b$6�Gݓ�B�.Ŏ�%�6����X�|���^H���Sf�KHX>ٱ�h���I`�o��ܝ�5��q!���>��&s��eĺW�'���H����.Kjw�e����%���2ݕ-e/�z�+������iP'�D������g�OZb��f���6����]K_��K*���%�/D"
�x�~����N���������C��j�&sw}1Mu�>�����o���#����ŘIA䒺����^�������a�o ��tݥ      +   �   x�=�I
�@D�է�'����������k�E�������dYP��i�|%%�����ԅXE88_��K8�0"#��ط���Z
JA����e��K��=��Rg���<�A��Sl�М�U��g3DҼ��L6�Q�<�-�oF�����72����xalI�{,]N���y�����I~      /   w   x�E�A
�0��"'(�mQ��F(R\���,����D����0�߳n�� <��-{�4PZ\��UݔG�`I��M�Z�)��}+���ר�,׮l�-��/�Ų���xoH~  L&      0   >   x���	 1Bѳ�ę!$���:V/��</t�M-Tbg6%L�U~:��v����>�?f��     