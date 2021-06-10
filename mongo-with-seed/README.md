# Build custom mongo image
docker build -t mongo-with-demo-data .

# Deploy in k8s
kubectl apply -f .

# Connection string
mongodb://MONGO_HOST:PORT

# Import data in db (from mongo pod)
mongoimport \
    --host mongodb \
    --username demo-user \
    --password 1234 \
    --authenticationDatabase admin \
    --db demo-data \
    --collection users \
    --type json \
    --file /demo-data/users.json \
    --jsonArray