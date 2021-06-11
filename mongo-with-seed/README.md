# Build custom mongo image
docker build -t mongo-with-demo-data .

# Create config map with demo-data
# Delete if already created (kubectl delete configmap mongo-seed -n db-demo)
kubectl create configmap mongo-seed --from-file demo-data -n db-demo

# Deploy in k8s
kubectl apply -f .

# Clean everything
kubectl delete -f .
kubectl delete configmap mongo-seed -n db-demo

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
