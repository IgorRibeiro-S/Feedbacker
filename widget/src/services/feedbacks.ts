import { AxiosInstance } from 'axios'
import { Feedback } from '../types/feedback'
import { RequestError } from '../types/error'

type Create = {
    data: Feedback;
    errors: RequestError | null
}

type CreatePayload = {
  type: string;
  text: string;
  fingerprint: string;
  apiKey: string;
  device: string;
  page: string;
  idUser: string;
  user: {
    id: string;
  };
}

export interface IFeedbackService {
    create(create: CreatePayload): Promise<Create>;
}

function FeedbacksService (httpClient: AxiosInstance): IFeedbackService {
  async function create (payload: CreatePayload): Promise<Create> {
    payload.user.id = payload.idUser
    const response = await httpClient.post<Feedback>('/feedbacks', payload)
    let errors: RequestError | null = null

    if (response.status === 400 || response.status === 500 || response.status === 401 || response.status === 403) {
      errors = {
        status: response.request.status,
        statusText: response.request.statusText
      }
    }
    return {
      data: response.data,
      errors
    }
  }
  return {
    create
  }
}

export default FeedbacksService
