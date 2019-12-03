const axios = require('axios')
const aws = require('aws-sdk')
const db = new aws.DynamoDB.DocumentClient({region: 'ap-southeast-2'})
const coins = ['BTC', 'ETH', 'XRP', 'BCH', 'LTC']

function getLiveprice(JWT, amount, coin) {
    const url = "https://api.swyftx.com.au/orders/rate"
    const body = {
        "buy": "AUD",
        "sell": coin,
        "amount": amount,
        "limit": coin
    }
    return axios.post(url, body, {
        headers: {
            'Content-Type': "application/json",
            'Authorization': `Bearer ${JWT}`
        }
    })
}


async function livepriceCallback(JWT, amount, coin) {
    try {
        const res = await getLiveprice(JWT, amount, coin)
        if (res.status === 200) {
            return res.data.amount
        }
    } catch (e) {
        console.log(e)
    }
}

exports.handler = function (event, ctx, callback) {
    getJWT()

    function getJWT() {
        const params = {
            TableName: "SwyftxToken",
            Key: {
                "account": "andrew4964@gmail.com"
            },
        }
        db.get(params, (err, data) => {
            if (err) callback(err)
            else {
                for (const coin in coins) {
                    livepriceCallback(data['Item']['JWT'], 1, coin).then(res => {

                        const params = {
                            TableName: 'Public',
                            Key: {name: 'liveprice' + coin + 'sx'},
                            UpdateExpression: 'set price = :p',
                            ExpressionAttributeValues: {':p': (Number(res) * 0.97).toFixed(2)},
                            ReturnValues: 'UPDATED_NEW'
                        }
                        db.update(params, (err, data) => {
                            if (err) callback(err)
                            else {
                                callback(null, data)
                            }
                        })
                    })
                }
            }
        })
    }
}
