### Prepare for example

```sql
CREATE TABLE account (
    id BIGINT NOT NULL PRIMARY KEY,
    balance DOUBLE NOT NULL
);

INSERT INTO account (id, balance) VALUES (1, 1000.00);
INSERT INTO account (id, balance) VALUES (2, 1000.00);
```
