// The 'CLOUD_PROVIDER' variable is passed in via the Binding in the shell
def providers = [
    'AWS'  : ['us-east-1', 'us-west-2'],
    'GCP'  : ['us-central1', 'europe-west1'],
    'Azure': ['East US', 'West Europe']
]

return providers.get(CLOUD_PROVIDER, ['Select a valid provider'])
