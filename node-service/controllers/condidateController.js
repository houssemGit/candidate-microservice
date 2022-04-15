const axios = require("axios")
const defaultData = require("../defaultdata")
const cv = require("../models/cv")
const { uniqueNamesGenerator, Config, starWars } = require ('unique-names-generator');

class condidateController {

    async uploadAndResolveCV(req,res) {
        console.log(req.file.filename)
        let api_result = null
        let candidate_data;
        /*api_result = await axios.get(`https://api.apilayer.com/resume_parser/url?url=http://63a0-197-15-20-142.ngrok.io/api/candidate/download/Houssem_ZeraiCV.pdf`,{
            headers:{
                "apikey":"OPi2GRLDsT0ON3bDMxpb2eJdttpHRpz1"
            },
        })*/
        if (api_result)
            candidate_data = api_result.data
        else{
            candidate_data = defaultData
            candidate_data.name = uniqueNamesGenerator({
                dictionaries: [starWars]
              })
        }

        await cv.create({raw_data:candidate_data,path:req.file.path,fileName:req.file.filename})            
        return res.json({status:"done",candidate_data})
    }

    async downloadFile(req,res){
        const file = `./uploads/${req.params.name}`;
        return res.download(file);
    }
}

module.exports = condidateController