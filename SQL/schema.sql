DROP TABLE "public"."transporter";

CREATE TABLE "public"."transporter"
(
    "id"              SERIAL PRIMARY KEY,
    "name"            varchar        NOT NULL,
    "company"         varchar        NOT NULL,
    "email"           varchar        NOT NULL,
    "phone_number"    varchar        NOT NULL,
    "mobile_number"   varchar,
    "whatsapp_number" varchar,
    "modal"           character(1)[] NOT NULL,
    "cep"             varchar        NOT NULL,
    "city"            varchar        NOT NULL,
    "district"        varchar        NOT NULL,
    "street"          varchar        NOT NULL,
    "street_number"   varchar        NOT NULL,
    "company_logo"    bytea          NOT NULL,
    CONSTRAINT "transporters_modal" CHECK ( modal <@ '{R,W,A}'::character(1)[]),
    CONSTRAINT "transporters_company_size" CHECK ( length(company) >= 4 ),
    CONSTRAINT "transporters_cep_size" CHECK ( length(cep) = 9 )
);

CREATE INDEX "transporters_company" ON "public"."transporter" USING btree ("company");
CREATE INDEX "transporters_name" ON "public"."transporter" USING btree ("name");

COMMENT ON COLUMN "public"."transporter"."id" IS 'The unique identifier.';
COMMENT ON COLUMN "public"."transporter"."name" IS 'The transporter name.';
COMMENT ON COLUMN "public"."transporter"."company" IS 'The transporter company name.';
COMMENT ON COLUMN "public"."transporter"."email" IS 'The transporter e-mail.';
COMMENT ON COLUMN "public"."transporter"."phone_number" IS 'The transporter phone number.';
COMMENT ON COLUMN "public"."transporter"."mobile_number" IS 'The transporter mobile number.';
COMMENT ON COLUMN "public"."transporter"."whatsapp_number" IS 'The transporter WhatsApp number.';
COMMENT ON COLUMN "public"."transporter"."modal" IS 'The transporter modal, can be ''R'' = Rodoviário, ''W'' = ''Waterway'' and ''A'' = ''Airway''.';
COMMENT ON COLUMN "public"."transporter"."cep" IS 'The transporter CEP.';
COMMENT ON COLUMN "public"."transporter"."city" IS 'The transporter city.';
COMMENT ON COLUMN "public"."transporter"."district" IS 'The transporter district.';
COMMENT ON COLUMN "public"."transporter"."street" IS 'The transporter street.';
COMMENT ON COLUMN "public"."transporter"."street_number" IS 'The transporter street number.';
COMMENT ON COLUMN "public"."transporter"."company_logo" IS 'The transporter company logo.';
