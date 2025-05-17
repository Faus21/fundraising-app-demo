INSERT INTO fundraising_event (fund_id, name, amount, account_currency)
VALUES
    ('601e772b-e980-4a45-8bc4-89a2094fba75', 'Save the Forest', 0.00, 'USD'),
    ('1bfbfa5c-d8f5-438a-8bf8-06f2a900b17d', 'Help Children', 0.00, 'EUR');

INSERT INTO collection_box (collection_box_id, fund_id)
VALUES
    ('c8e03543-a0ae-4296-b69b-05170f2db6d6',NULL),
    ('d4e9b7a2-9cec-4a31-aa7d-62bf72791ee8','601e772b-e980-4a45-8bc4-89a2094fba75'),
    ('f48b8410-3e81-41c1-a8d4-1c2bbdfa935c','1bfbfa5c-d8f5-438a-8bf8-06f2a900b17d');

INSERT INTO transfer_collection_box (id, collection_box_id, currency, amount)
VALUES
    ('ba518f8c-eca3-4b0d-b836-a927f9d17652', 'd4e9b7a2-9cec-4a31-aa7d-62bf72791ee8', 'USD', 100.00),
    ('bc3b3aab-8dd8-4bf9-a907-d6d7babc389e', 'd4e9b7a2-9cec-4a31-aa7d-62bf72791ee8', 'EUR', 50.00),
    ('31b2fd19-24ce-41d5-880d-0d03b8957692', 'f48b8410-3e81-41c1-a8d4-1c2bbdfa935c', 'EUR', 200.00),
    ('06b65b9b-9cd6-41f0-bb8b-1194900595fe', 'f48b8410-3e81-41c1-a8d4-1c2bbdfa935c', 'PLN', 300.00);