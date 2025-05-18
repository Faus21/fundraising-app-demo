CREATE TABLE fundraising_event(
    fund_id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    account_currency VARCHAR(3) NOT NULL
);

CREATE TABLE collection_box (
    collection_box_id UUID PRIMARY KEY,
    fund_id UUID,
    FOREIGN KEY (fund_id) REFERENCES fundraising_event(fund_id)
);

CREATE TABLE transfer_collection_box(
    transfer_id UUID PRIMARY KEY,
    collection_box_id UUID NOT NULL,
    currency VARCHAR(3) NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    FOREIGN KEY (collection_box_id) REFERENCES collection_box(collection_box_id)
);

