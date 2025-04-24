-- Database schema for banking system

-- Users table for storing customer information
CREATE TABLE public.users (
  user_id    UUID PRIMARY KEY,
  name       VARCHAR(100) NOT NULL,
  email      VARCHAR(255) NOT NULL UNIQUE,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  status     VARCHAR(15) NOT NULL DEFAULT 'ACTIVE'
);

-- Currencies reference table
CREATE TABLE public.currencies (
       currency_id VARCHAR(3) PRIMARY KEY,
       name        VARCHAR(50) NOT NULL,
       symbol      VARCHAR(5) NOT NULL
);

-- Customer accounts table
CREATE TABLE public.accounts (
     account_id       UUID PRIMARY KEY,
     user_id         UUID NOT NULL REFERENCES public.users,
     currency_id     VARCHAR(3) NOT NULL REFERENCES public.currencies,
     account_number  VARCHAR(34) NOT NULL UNIQUE,
     status         VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
     created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
     updated_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
     balance NUMERIC(20,4) NOT NULL DEFAULT 0.0000
);

INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('USD', 'US Dollar', '$');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('EUR', 'Euro', '€');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('JPY', 'Japanese Yen', '¥');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('GBP', 'British Pound', '£');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('CNY', 'Chinese Yuan', '¥');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('AUD', 'Australian Dollar', 'A$');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('CAD', 'Canadian Dollar', 'C$');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('CHF', 'Swiss Franc', 'Fr');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('HKD', 'Hong Kong Dollar', 'HK$');
INSERT INTO public.currencies (currency_id, name, symbol) VALUES ('SGD', 'Singapore Dollar', 'S$');