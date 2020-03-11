DROP TABLE IF EXISTS "public"."transporters";

CREATE TABLE "public"."transporters"
(
    "id"              SERIAL PRIMARY KEY,
    "cnpj"            varchar unique not null,
    "name"            varchar        NOT NULL,
    "company"         varchar        NOT NULL,
    "email"           varchar        NOT NULL,
    "phone_number"    varchar        NOT NULL,
    "mobile_number"   varchar,
    "whatsapp_number" varchar,
    "modal"           character(1)[] NOT NULL,
    "cep"             varchar        NOT NULL,
    "state"           varchar        NOT NULL,
    "city"            varchar        NOT NULL,
    "district"        varchar        NOT NULL,
    "street"          varchar        NOT NULL,
    "street_number"   varchar        NOT NULL,
    "company_logo"    varchar        NOT NULL,
    CONSTRAINT "transporters_modal" CHECK ( modal <@ '{R,W,A}'::character(1)[]),
    CONSTRAINT "transporters_company_size" CHECK ( length(company) >= 4 ),
    CONSTRAINT "transporters_cep_size" CHECK ( length(cep) = 8 )
);

CREATE INDEX "transporters_company" ON "public"."transporters" USING btree ("company");
CREATE INDEX "transporters_name" ON "public"."transporters" USING btree ("name");

COMMENT ON COLUMN "public"."transporters"."id" IS 'The unique identifier.';
COMMENT ON COLUMN "public"."transporters"."cnpj" IS 'The transporters CNPJ.';
COMMENT ON COLUMN "public"."transporters"."name" IS 'The transporters name.';
COMMENT ON COLUMN "public"."transporters"."company" IS 'The transporters company name.';
COMMENT ON COLUMN "public"."transporters"."email" IS 'The transporters e-mail.';
COMMENT ON COLUMN "public"."transporters"."phone_number" IS 'The transporters phone number.';
COMMENT ON COLUMN "public"."transporters"."mobile_number" IS 'The transporters mobile number.';
COMMENT ON COLUMN "public"."transporters"."whatsapp_number" IS 'The transporters WhatsApp number.';
COMMENT ON COLUMN "public"."transporters"."modal" IS 'The transporters modal, can be ''R'' = Rodoviário, ''W'' = ''Waterway'' and ''A'' = ''Airway''.';
COMMENT ON COLUMN "public"."transporters"."cep" IS 'The transporters CEP.';
COMMENT ON COLUMN "public"."transporters"."city" IS 'The transporters city.';
COMMENT ON COLUMN "public"."transporters"."state" IS 'The transporters state.';
COMMENT ON COLUMN "public"."transporters"."district" IS 'The transporters district.';
COMMENT ON COLUMN "public"."transporters"."street" IS 'The transporters street.';
COMMENT ON COLUMN "public"."transporters"."street_number" IS 'The transporters street number.';
COMMENT ON COLUMN "public"."transporters"."company_logo" IS 'The transporters company logo.';
